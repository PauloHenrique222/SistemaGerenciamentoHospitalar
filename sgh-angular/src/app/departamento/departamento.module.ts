import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {ReactiveFormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {DepartamentoListarComponent} from './departamento-listar/departamento-listar.component';
import {DepartamentoRoutingModule} from './departamento-routing.module';
import { DepartamentoDetalheComponent } from './departamento-detalhe/departamento-detalhe.component';

@NgModule({
  declarations: [
    DepartamentoListarComponent,
    DepartamentoDetalheComponent,
  ],
  imports: [
    CommonModule,
    MatTableModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    DepartamentoRoutingModule
  ]
})
export class DepartamentoModule { }
