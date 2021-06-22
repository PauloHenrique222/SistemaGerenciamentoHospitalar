import { Component, OnInit } from '@angular/core';
import {DateAdapter, ErrorStateMatcher, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {MAT_MOMENT_DATE_ADAPTER_OPTIONS, MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {DepartamentoService} from '../departamento.service';
import {Departamento} from '../../../model/departamento';

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-departamento-detalhe',
  templateUrl: './departamento-detalhe.component.html',
  styleUrls: ['./departamento-detalhe.component.css'],
  providers: [
    // The locale would typically be provided on the root module of your application. We do it at
    // the component level here, due to limitations of our example generation script.
    {provide: MAT_DATE_LOCALE, useValue: 'pt-BR'},

    // `MomentDateAdapter` and `MAT_MOMENT_DATE_FORMATS` can be automatically provided by importing
    // `MatMomentDateModule` in your applications root module. We provide it at the component level
    // here, due to limitations of our example generation script.
    {
      provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]
    },
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},
  ],
})
export class DepartamentoDetalheComponent implements OnInit, ErrorStateMatcher{

  constructor(private departamentoService: DepartamentoService,
              private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
  ) {
  }

  departamento: Departamento;

  formDepartamento: FormGroup;

  matcher = new MyErrorStateMatcher();

  inscricao: Subscription;

  ngOnInit(): void {
    this.inscricao = this.route.params.subscribe(
      (params: Params) => {
        const id: number = +params.id;
        if (id) {
          this.departamentoService.bucarDepartamentoPorId(id).subscribe(dados => {
            this.departamento = dados;
            this.formDepartamento = this.fb.group({
              id: [this.departamento.id],
              usuarioId: [this.departamento.usuarioId],
              nome: [this.departamento.nome, [Validators.required, Validators.minLength(3)]],
            });
          }, error => {console.error(error); });
        } else {
          this.departamento = {
            id: null,
            usuarioId: +localStorage.getItem('usuario_id'),
            nome: '',
          };
          this.formDepartamento = this.fb.group({
            id: [this.departamento.id],
            usuarioId: [this.departamento.usuarioId],
            nome: [this.departamento.nome, Validators.required],
          });
        }
      });
  }

  onSubmit(): void {
    this.departamento = this.formDepartamento.value;
    if (this.departamento.id === null){
      this.departamentoService.salvarDepartamento(this.departamento).subscribe(() => {
        this.departamentoService.showMessage('Departamento salvo com sucesso', false);
      });
      this.router.navigate(['/listar-departamentos']).then(() => {
        window.location.reload();
      });
    }else{
      this.departamentoService.editarDepartamento(this.departamento).subscribe(() => {
        this.departamentoService.showMessage('Atualizado com sucesso', false);
      });
      this.router.navigate(['/listar-departamentos']).then(() => {
        window.location.reload();
      });
    }
  }

  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    return false;
  }

  get getControl(){
    return this.formDepartamento.controls;
  }

  voltar(): void {
    this.router.navigate(['/listar-departamentos']);
  }

}
