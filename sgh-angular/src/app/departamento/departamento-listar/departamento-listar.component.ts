import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import {Router} from '@angular/router';
import {DepartamentoService} from '../departamento.service';
import {Departamento} from '../../../model/departamento';

@Component({
  selector: 'app-departamento',
  templateUrl: './departamento-listar.component.html',
  styleUrls: ['./departamento-listar.component.css']
})
export class DepartamentoListarComponent implements OnInit {

  constructor(
    private departamentoService: DepartamentoService,
    private location: Location,
    private router: Router
  ) { }

  displayedColumns: string[] = ['id', 'nome', 'acoes'];

  departamentos: Departamento[];

  dataSource;

  ngOnInit(): void {
    this.departamentoService.listarDepartamento().subscribe(dados => {
      this.departamentos = dados;
      this.dataSource = this.departamentos;
    });
  }

  editar(departamento: Departamento): void {
    this.router.navigate(['/departamento-detalhe', departamento.id]);
  }

  cadastrar(): void {
    this.router.navigate(['/departamento-detalhe'])
      .then(() => {
        window.location.reload();
      });
  }

  deletarDepartamento(departamento: Departamento): void {
    this.departamentoService.deletarDepartamento(departamento.id).subscribe(dados => {
      this.router.navigate(['/listar-departamentos'])
        .then(() => {
          window.location.reload();
        });
    });
  }

}
