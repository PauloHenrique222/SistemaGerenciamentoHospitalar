import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TipoComponent } from './tipo/tipo.component';
import {MatTableModule} from '@angular/material/table';

@NgModule({
  declarations: [TipoComponent],
  exports: [
    TipoComponent
  ],
  imports: [
    CommonModule,
    MatTableModule
  ]
})
export class TipoModule { }
