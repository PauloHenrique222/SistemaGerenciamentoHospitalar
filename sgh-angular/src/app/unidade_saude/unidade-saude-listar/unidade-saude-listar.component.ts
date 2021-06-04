import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import {Router} from '@angular/router';
import {UnidadeSaudeService} from '../unidade-saude.service';
import {UnidadeSaudeDto} from '../../../model/unidade-saude-dto';

@Component({
  selector: 'app-unidade-saude-listar',
  templateUrl: './unidade-saude-listar.component.html',
  styleUrls: ['./unidade-saude-listar.component.css']
})
export class UnidadeSaudeListarComponent implements OnInit {

  constructor(
    private unidadeService: UnidadeSaudeService,
    private location: Location,
    private router: Router
  ) { }

  displayedColumns: string[] = ['id', 'nome', 'numeroRegistro', 'tipo', 'acoes'];

  unidades: UnidadeSaudeDto[];

  dataSource;

  ngOnInit(): void {
    this.unidadeService.listarUnidade().subscribe(dados => {
      this.unidades = dados;
      this.dataSource = this.unidades;
    });
  }

  editar(unidade: UnidadeSaudeDto): void {
    this.router.navigate(['/unidade-detalhe']);
  }

  cadastrar(): void {
    this.router.navigate(['/unidade-detalhe']);
  }

}
