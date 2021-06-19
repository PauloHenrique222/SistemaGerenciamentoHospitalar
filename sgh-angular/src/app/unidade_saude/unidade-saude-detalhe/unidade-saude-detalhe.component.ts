import { Component, OnInit } from '@angular/core';
import {DateAdapter, ErrorStateMatcher, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {MAT_MOMENT_DATE_ADAPTER_OPTIONS, MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {UnidadeSaudeService} from '../unidade-saude.service';
import {UnidadeSaude} from '../../../model/unidade-saude';
import {Tipo} from '../../../model/tipo';
import {Endereco} from '../../../model/endereco';


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

  unidade: UnidadeSaude;

  tipo: Tipo;

  endereco: Endereco;

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
            this.formUnidade = this.fb.group({
              id: [this.unidade.id],
              nome: [this.unidade.nome, Validators.required, Validators.minLength(3)],
              numeroRegistro: [this.unidade.numeroRegistro, Validators.required],
              tipoId: [this.unidade.tipo.id, Validators.required],
              rua: [this.unidade.endereco.rua, Validators.required],
              cep: [this.unidade.endereco.cep, Validators.required],
              complemento: [this.unidade.endereco.complemento, Validators.required],
              setor: [this.unidade.endereco.setor, Validators.required],
              numero: [this.unidade.endereco.numero, Validators.required],
              pais: [this.unidade.endereco.pais, Validators.required],
              estado: [this.unidade.endereco.estado, Validators.required],
              cidade: [this.unidade.endereco.cidade, Validators.required],
            });
            console.log(this.formUnidade);
          }, error => {console.error(error); });
        } else {
          this.tipo = {
            id: null,
            usuarioId: null,
            nome: '',
          };
          this.endereco = {
            rua: '',
            cep: '',
            complemento: '',
            setor: '',
            numero: null,
            pais: '',
            estado: '',
            cidade: '',
          };
          this.unidade = {
            id: null,
            nome: '',
            numeroRegistro: '',
            tipo: this.tipo,
            endereco: this.endereco
          };
          this.formUnidade = this.fb.group({
            id: [this.unidade.id],
            nome: [this.unidade.nome, Validators.required],
            numeroRegistro: [this.unidade.numeroRegistro, Validators.required],
            tipoId: [this.unidade.tipo.id, Validators.required],
            rua: [this.unidade.endereco.rua, Validators.required],
            cep: [this.unidade.endereco.cep, Validators.required],
            complemento: [this.unidade.endereco.complemento, Validators.required],
            setor: [this.unidade.endereco.setor, Validators.required],
            numero: [this.unidade.endereco.numero, Validators.required],
            pais: [this.unidade.endereco.pais, Validators.required],
            estado: [this.unidade.endereco.estado, Validators.required],
            cidade: [this.unidade.endereco.cidade, Validators.required],
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
