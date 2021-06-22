import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSliderModule} from '@angular/material/slider';
import {HttpClientModule} from '@angular/common/http';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {IConfig, NgxMaskModule} from 'ngx-mask';
import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app-routing.module';
import {LoginModule} from './login/login.module';
import {TipoModule} from './tipo/tipo.module';
import {UnidadeSaudeModule} from './unidade_saude/unidade-saude.module';
import {CadastroModule} from './cadastro/cadastro.module';
import {HomeModule} from './home/home.module';
import {DepartamentoModule} from './departamento/departamento.module';
import {CargoModule} from './cargo/cargo.module';

export const options: Partial<IConfig> | (() => Partial<IConfig>) = null;

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatSliderModule,
    HttpClientModule,
    MatSnackBarModule,
    NgxMaskModule.forRoot(),
    RouterModule,
    AppRoutingModule,
    LoginModule,
    TipoModule,
    UnidadeSaudeModule,
    CadastroModule,
    HomeModule,
    DepartamentoModule,
    CargoModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
