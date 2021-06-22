import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {ReactiveFormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {CargoListarComponent} from './cargo-listar/cargo-listar.component';
import {CargoDetalheComponent } from './cargo-detalhe/cargo-detalhe.component';
import {CargoRoutingModule} from './cargo-routing.module';

@NgModule({
  declarations: [
    CargoListarComponent,
    CargoDetalheComponent,

  ],
  imports: [
    CommonModule,
    MatTableModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    CargoRoutingModule,
  ]
})
export class CargoModule { }
