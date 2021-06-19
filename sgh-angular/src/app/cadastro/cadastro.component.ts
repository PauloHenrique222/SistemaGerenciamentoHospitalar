import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {UsuarioDao} from '../../model/usuario-dao';
import {AuthGuardService} from '../guards/auth.guard.service';
import {CadastroService} from './cadastro.service';


@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  formCadastro: FormGroup;
  private formSubmitAttempt: boolean;
  private usuarioDao: UsuarioDao;

  constructor(
    private fb: FormBuilder,
    private authService: AuthGuardService,
    private router: Router,
    private cadastroService: CadastroService
  ) {}

  ngOnInit(): void {
    this.formCadastro = this.fb.group({
      nome: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      passwordConfirmation: ['', Validators.required]
    });
  }

  isFieldInvalid(field: string) {
    return (
      (!this.formCadastro.get(field).valid && this.formCadastro.get(field).touched) ||
      (this.formCadastro.get(field).untouched && this.formSubmitAttempt)
    );
  }

  onSubmit(): void {
    if (this.formCadastro.valid) {
      this.cadastroService.cadastrar(this.formCadastro.value).subscribe((dado) => {
        this.cadastroService.showMessage('Cadastro salvo com sucesso', false);
        this.usuarioDao = { email: this.formCadastro.value.email, password: this.formCadastro.value.password };
        this.authService.login(this.usuarioDao);
      });
    }
    this.formSubmitAttempt = true;
  }

  voltar(): void {
    this.router.navigate(['/login']);
  }

}
