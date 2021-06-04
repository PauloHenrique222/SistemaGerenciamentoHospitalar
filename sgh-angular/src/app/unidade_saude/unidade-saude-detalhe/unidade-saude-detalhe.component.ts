import { Component, OnInit } from '@angular/core';
import {DateAdapter, ErrorStateMatcher, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {MAT_MOMENT_DATE_ADAPTER_OPTIONS, MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {UnidadeSaudeService} from '../unidade-saude.service';
import {UnidadeSaudeDao} from '../../../model/unidade-saude-dao';


/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-unidade-saude-detalhe',
  templateUrl: './unidade-saude-detalhe.component.html',
  styleUrls: ['./unidade-saude-detalhe.component.css'],
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
export class UnidadeSaudeDetalheComponent implements OnInit {

  constructor(private unidadeSaudeService: UnidadeSaudeService,
              private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
  ) {
  }

  unidade: UnidadeSaudeDao;

  formUnidade: FormGroup;

  matcher = new MyErrorStateMatcher();

  inscricao: Subscription;

  ngOnInit(): void {
    this.inscricao = this.route.params.subscribe(
      (params: Params) => {
        const id: number = +params.id;
        if (id) {
          this.unidadeSaudeService.bucarUnidadePorId(id).subscribe(dados => {
            this.unidade = dados;
            this.formUnidade = this.fb.group({     // {5}
              id: [this.unidade.id],
              nome: [this.unidade.nome, Validators.required],
              numeroRegistro: [this.unidade.numeroRegistro, Validators.required],
              tipoId: [this.unidade.tipoId, Validators.required],
            });
            console.log(this.formUnidade);
          }, error => {console.error(error); });
        } else {
          this.unidade = {
            id: null,
            nome: '',
            numeroRegistro: '',
            tipoId: null,
            endereco: null
          };
          this.formUnidade = this.fb.group({     // {5}
            id: [this.unidade.id],
            nome: [this.unidade.nome, Validators.required],
            numeroRegistro: [this.unidade.numeroRegistro, Validators.required],
            tipoId: [this.unidade.tipoId, Validators.required],
          });
        }
      });
  }

  onSubmit(): void {
  }

  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    return false;
  }

  get getControl(){
    return this.formUnidade.controls;
  }

  voltar(): void {
    this.router.navigate(['/unidades']);
  }

}
