import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import {Router} from '@angular/router';
import {TipoService} from '../tipo.service';
import {TipoDto} from '../../../model/tipo-dto';

@Component({
  selector: 'app-tipo-listar',
  templateUrl: './tipo-listar.component.html',
  styleUrls: ['./tipo-listar.component.css']
})
export class TipoListarComponent implements OnInit {

  constructor(
    private tipoService: TipoService,
    private location: Location,
    private router: Router
  ) { }

  displayedColumns: string[] = ['id', 'nome', 'acoes'];

  tipos: TipoDto[];

  dataSource;

  ngOnInit(): void {
    this.tipoService.listarTipo().subscribe(dados => {
      this.tipos = dados;
      this.dataSource = this.tipos;
    });
  }

  editar(tipo: TipoDto): void {
    this.router.navigate(['/tipo-detalhe', tipo.id]);
  }

  cadastrar(): void {
    this.router.navigate(['/tipo-detalhe']);
  }

}
