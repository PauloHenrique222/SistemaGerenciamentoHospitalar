import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from '../guards/auth.guard';
import {NgModule} from '@angular/core';
import {CargoDetalheComponent} from './cargo-detalhe/cargo-detalhe.component';
import {CargoListarComponent} from './cargo-listar/cargo-listar.component';


const cargoRoutes: Routes = [
  {path: 'listar-cargos', component: CargoListarComponent, canActivate: [AuthGuard]},
  {path: 'cargo-detalhe', component: CargoDetalheComponent, canActivate: [AuthGuard]},
  {path: 'cargo-detalhe/:id', component: CargoDetalheComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forChild(cargoRoutes)],
  exports: [RouterModule]
})
export class CargoRoutingModule { }
