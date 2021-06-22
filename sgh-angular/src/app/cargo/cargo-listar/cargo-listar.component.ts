import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import {Router} from '@angular/router';
import {CargoService} from '../cargo.service';
import {Cargo} from '../../../model/cargo';

@Component({
  selector: 'app-cargo',
  templateUrl: './cargo-listar.component.html',
  styleUrls: ['./cargo-listar.component.css']
})
export class CargoListarComponent implements OnInit {

  constructor(
    private cargoService: CargoService,
    private location: Location,
    private router: Router
  ) { }

  displayedColumns: string[] = ['id', 'nome', 'acoes'];

  cargos: Cargo[];

  dataSource;

  ngOnInit(): void {
    this.cargoService.listarCargo().subscribe(dados => {
      this.cargos = dados;
      this.dataSource = this.cargos;
    });
  }

  editar(cargo: Cargo): void {
    this.router.navigate(['/cargo-detalhe', cargo.id]);
  }

  cadastrar(): void {
    this.router.navigate(['/cargo-detalhe'])
      .then(() => {
        window.location.reload();
      });
  }

  deletarCargo(cargo: Cargo): void {
    this.cargoService.deletarCargo(cargo.id).subscribe(dados => {
      this.router.navigate(['/listar-cargos'])
        .then(() => {
          window.location.reload();
        });
    });
  }

}
