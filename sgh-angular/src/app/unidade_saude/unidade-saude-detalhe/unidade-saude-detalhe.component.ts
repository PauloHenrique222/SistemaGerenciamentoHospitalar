import { Component, OnInit } from '@angular/core';
import {DateAdapter, ErrorStateMatcher, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {MAT_MOMENT_DATE_ADAPTER_OPTIONS, MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {UnidadeSaudeService} from '../unidade-saude.service';
import {UnidadeSaude} from '../../../model/unidade-saude';
import {Tipo} from '../../../model/tipo';
import {TipoService} from '../../tipo/tipo.service';
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
export class UnidadeSaudeDetalheComponent implements OnInit, ErrorStateMatcher{
  constructor(private unidadeSaudeService: UnidadeSaudeService,
              private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
              private tipoService: TipoService,
  ) {
  }

  unidade: UnidadeSaude;

  tipo: Tipo;

  endereco: Endereco;

  formUnidade: FormGroup;

  matcher = new MyErrorStateMatcher();

  inscricao: Subscription;

  tipos: Tipo[];

  ngOnInit(): void {
    this.tipoService.listarTipo().subscribe(dados => {
      this.tipos = dados;
    });
    this.inscricao = this.route.params.subscribe(
      (params: Params) => {
        const id: number = +params.id;
        if (id) {
          this.unidadeSaudeService.bucarUnidadePorId(id).subscribe(dados => {
            this.unidade = dados;
            this.formUnidade = this.fb.group({
              id: [this.unidade.id],
              usuarioId: [this.unidade.usuarioId],
              nome: [this.unidade.nome, Validators.required],
              numeroRegistro: [this.unidade.numeroRegistro, Validators.required],
              telefone: [this.unidade.telefone, Validators.required],
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
            usuarioId: +localStorage.getItem('usuario_id'),
            nome: '',
            telefone: '',
            numeroRegistro: '',
            tipo: this.tipo,
            endereco: this.endereco
          };
          this.formUnidade = this.fb.group({
            id: [this.unidade.id],
            usuarioId: [this.unidade.usuarioId],
            nome: [this.unidade.nome, Validators.required],
            numeroRegistro: [this.unidade.numeroRegistro, Validators.required],
            telefone: [this.unidade.telefone, Validators.required],
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
    this.tipoService.bucarTipoPorId(+this.formUnidade.value.tipoId).subscribe(dados => {
      this.tipo = dados;
      this.endereco = {
        rua: this.formUnidade.value.rua,
        cep: this.formUnidade.value.cep,
        complemento: this.formUnidade.value.complemento,
        setor: this.formUnidade.value.setor,
        numero: this.formUnidade.value.numero,
        pais: this.formUnidade.value.pais,
        estado: this.formUnidade.value.estado,
        cidade: this.formUnidade.value.cidade,
      };
      this.unidade = {
        id: this.formUnidade.value.id,
        usuarioId: this.formUnidade.value.usuarioId,
        nome: this.formUnidade.value.nome,
        telefone: this.formUnidade.value.telefone,
        numeroRegistro: this.formUnidade.value.numeroRegistro,
        tipo: this.tipo,
        endereco: this.endereco
      };
      if (this.unidade.id === null){
        this.unidadeSaudeService.salvarUnidade(this.unidade).subscribe(() => {
          this.tipoService.showMessage('Unidade salvo com sucesso', false);
        });
        this.router.navigate(['/unidades']).then(() => {
          window.location.reload();
        });
      }else{
        this.unidadeSaudeService.editarUnidade(this.unidade).subscribe(() => {
          this.tipoService.showMessage('Atualizado com sucesso', false);
        });
        this.router.navigate(['/unidades']).then(() => {
          window.location.reload();
        });
      }
    });
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
