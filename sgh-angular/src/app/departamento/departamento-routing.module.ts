import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from '../guards/auth.guard';
import {NgModule} from '@angular/core';
import {DepartamentoListarComponent} from './departamento-listar/departamento-listar.component';
import {DepartamentoDetalheComponent} from './departamento-detalhe/departamento-detalhe.component';


const departamentoRoutes: Routes = [
  {path: 'listar-departamentos', component: DepartamentoListarComponent, canActivate: [AuthGuard]},
  {path: 'departamento-detalhe', component: DepartamentoDetalheComponent, canActivate: [AuthGuard]},
  {path: 'departamento-detalhe/:id', component: DepartamentoDetalheComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forChild(departamentoRoutes)],
  exports: [RouterModule]
})
export class DepartamentoRoutingModule { }
