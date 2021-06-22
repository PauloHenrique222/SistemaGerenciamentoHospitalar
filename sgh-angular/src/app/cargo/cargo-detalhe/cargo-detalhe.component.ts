import { Component, OnInit } from '@angular/core';
import {DateAdapter, ErrorStateMatcher, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {MAT_MOMENT_DATE_ADAPTER_OPTIONS, MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {CargoService} from '../cargo.service';
import {Cargo} from '../../../model/cargo';

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-cargo-detalhe',
  templateUrl: './cargo-detalhe.component.html',
  styleUrls: ['./cargo-detalhe.component.css'],
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
export class CargoDetalheComponent implements OnInit, ErrorStateMatcher {

  constructor(private cargoService: CargoService,
              private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
  ) {
  }

  cargo: Cargo;

  formCargo: FormGroup;

  matcher = new MyErrorStateMatcher();

  inscricao: Subscription;

  ngOnInit(): void {
    this.inscricao = this.route.params.subscribe(
      (params: Params) => {
        const id: number = +params.id;
        if (id) {
          this.cargoService.bucarCargoPorId(id).subscribe(dados => {
            this.cargo = dados;
            this.formCargo = this.fb.group({
              id: [this.cargo.id],
              usuarioId: [this.cargo.usuarioId],
              nome: [this.cargo.nome, [Validators.required, Validators.minLength(3)]],
            });
          }, error => {console.error(error); });
        } else {
          this.cargo = {
            id: null,
            usuarioId: +localStorage.getItem('usuario_id'),
            nome: '',
          };
          this.formCargo = this.fb.group({
            id: [this.cargo.id],
            usuarioId: [this.cargo.usuarioId],
            nome: [this.cargo.nome, Validators.required],
          });
        }
      });
  }

  onSubmit(): void {
    this.cargo = this.formCargo.value;
    if (this.cargo.id === null){
      this.cargoService.salvarCargo(this.cargo).subscribe(() => {
        this.cargoService.showMessage('Departamento salvo com sucesso', false);
      });
      this.router.navigate(['/listar-cargos']).then(() => {
        window.location.reload();
      });
    }else{
      this.cargoService.editarCargo(this.cargo).subscribe(() => {
        this.cargoService.showMessage('Atualizado com sucesso', false);
      });
      this.router.navigate(['/listar-cargos']).then(() => {
        window.location.reload();
      });
    }
  }

  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    return false;
  }

  get getControl(){
    return this.formCargo.controls;
  }

  voltar(): void {
    this.router.navigate(['/listar-cargos']);
  }

}
