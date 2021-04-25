import { Component, OnInit } from '@angular/core';
import {TipoModule} from '../tipo.module';

@Component({
  selector: 'app-tipo',
  templateUrl: './tipo.component.html',
  styleUrls: ['./tipo.component.css']
})

export class TipoComponent implements OnInit {
  constructor() { }
  displayedColumns: string[] = ['id', 'nome'];
  tipos: TipoModule[] = [
    {id: 1, nome: 'Hydrogen'},
    {id: 2, nome: 'Helium'}
  ];
  dataSource = this.tipos;
  ngOnInit(): void {
  }
}

