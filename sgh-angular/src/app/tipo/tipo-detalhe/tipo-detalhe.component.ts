import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators, FormGroup, FormBuilder} from '@angular/forms';
import {DateAdapter, ErrorStateMatcher, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import {MAT_MOMENT_DATE_ADAPTER_OPTIONS, MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {TipoService} from '../tipo.service';
import {Tipo} from '../../../model/tipo';

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-tipo-detalhe',
  templateUrl: './tipo-detalhe.component.html',
  styleUrls: ['./tipo-detalhe.component.css'],
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
export class TipoDetalheComponent implements OnInit, ErrorStateMatcher{

  constructor(private tipoService: TipoService,
              private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
  ) {
  }

  tipo: Tipo;

  formTipo: FormGroup;

  matcher = new MyErrorStateMatcher();

  inscricao: Subscription;

  ngOnInit(): void {
    this.inscricao = this.route.params.subscribe(
      (params: Params) => {
        const id: number = +params.id;
        if (id) {
          this.tipoService.bucarTipoPorId(id).subscribe(dados => {
            this.tipo = dados;
            this.formTipo = this.fb.group({
              id: [this.tipo.id],
              usuarioId: [this.tipo.usuarioId],
              nome: [this.tipo.nome, [Validators.required, Validators.minLength(3)]],
            });
          }, error => {console.error(error); });
        } else {
          this.tipo = {
            id: null,
            usuarioId: +localStorage.getItem('usuario_id'),
            nome: '',
          };
          this.formTipo = this.fb.group({
            id: [this.tipo.id],
            usuarioId: [this.tipo.usuarioId],
            nome: [this.tipo.nome, Validators.required],
          });
        }
      });
  }

  onSubmit(): void {
    this.tipo = this.formTipo.value;
    if (this.tipo.id === null){
      this.tipoService.salvarTipo(this.tipo).subscribe(() => {
        this.tipoService.showMessage('Tipo salvo com sucesso', false);
      });
      this.router.navigate(['/listar-tipos']);
    }else{
      this.tipoService.editarTipo(this.tipo).subscribe(() => {
        this.tipoService.showMessage('Atualizado com sucesso', false);
      });
      this.router.navigate(['/listar-tipos']);
    }
  }

  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    return false;
  }

  get getControl(){
    return this.formTipo.controls;
  }

  voltar(): void {
    this.router.navigate(['/listar-tipos']);
  }

}
