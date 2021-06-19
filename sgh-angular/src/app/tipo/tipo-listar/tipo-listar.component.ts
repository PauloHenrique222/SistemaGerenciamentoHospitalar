import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import {Router} from '@angular/router';
import {TipoService} from '../tipo.service';
import {Tipo} from '../../../model/tipo';

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

  tipos: Tipo[];

  dataSource;

  ngOnInit(): void {
    this.tipoService.listarTipo().subscribe(dados => {
      this.tipos = dados;
      this.dataSource = this.tipos;
    });
  }

  editar(tipo: Tipo): void {
    this.router.navigate(['/tipo-detalhe', tipo.id]);
  }

  cadastrar(): void {
    this.router.navigate(['/tipo-detalhe'])
      .then(() => {
        window.location.reload();
      });
  }

  deletarTipo(tipo: Tipo): void {
    this.tipoService.deletarTipo(tipo.id).subscribe(dados => {
      this.router.navigate(['/listar-tipos'])
        .then(() => {
          window.location.reload();
        });
    });
  }

}
