import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UnidadeSaudeRoutingModule } from './unidade-saude-routing.module';
import {UnidadeSaudeListarComponent} from './unidade-saude-listar/unidade-saude-listar.component';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import { UnidadeSaudeDetalheComponent } from './unidade-saude-detalhe/unidade-saude-detalhe.component';
import {ReactiveFormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';



@NgModule({
  declarations: [
    UnidadeSaudeListarComponent,
    UnidadeSaudeDetalheComponent
  ],
  imports: [
    CommonModule,
    UnidadeSaudeRoutingModule,
    MatTableModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule
  ]
})
export class UnidadeSaudeModule { }
