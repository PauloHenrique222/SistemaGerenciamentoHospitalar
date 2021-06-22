import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import {Router} from '@angular/router';
import {UnidadeSaudeService} from '../unidade-saude.service';
import {UnidadeSaude} from '../../../model/unidade-saude';

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

  displayedColumns: string[] = ['id', 'nome', 'numeroRegistro', 'tipo', 'telefone', 'acoes'];

  unidades: UnidadeSaude[];

  dataSource;

  ngOnInit(): void {
    this.unidadeService.listarUnidade().subscribe(dados => {
      this.unidades = dados;
      this.dataSource = this.unidades;
    });
  }

  editar(unidade: UnidadeSaude): void {
    this.router.navigate(['/unidade-detalhe', unidade.id]);
  }

  cadastrar(): void {
    this.router.navigate(['/unidade-detalhe']);
  }

  deletarUnidade(unidade: UnidadeSaude): void {
    this.unidadeService.deletarUnidade(unidade.id).subscribe(dados => {
      this.router.navigate(['/unidades'])
        .then(() => {
          window.location.reload();
        });
    });
  }

}
