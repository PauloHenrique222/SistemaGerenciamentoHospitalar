import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {TipoListarComponent} from './tipo-listar/tipo-listar.component';
import {MatTableModule} from '@angular/material/table';
import { TipoRoutingModule } from './tipo-routing.module';
import {MatButtonModule} from '@angular/material/button';
import { TipoDetalheComponent } from './tipo-detalhe/tipo-detalhe.component';
import {ReactiveFormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';

@NgModule({
  declarations: [
    TipoListarComponent,
    TipoDetalheComponent
  ],
  imports: [
    CommonModule,
    MatTableModule,
    TipoRoutingModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule
  ]
})
export class TipoModule { }
