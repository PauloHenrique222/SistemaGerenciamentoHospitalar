import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from '../guards/auth.guard';
import {NgModule} from '@angular/core';
import {TipoListarComponent} from './tipo-listar/tipo-listar.component';
import {TipoDetalheComponent} from './tipo-detalhe/tipo-detalhe.component';


const tipoRoutes: Routes = [
  {path: 'listar-tipos', component: TipoListarComponent, canActivate: [AuthGuard]},
  {path: 'tipo-detalhe', component: TipoDetalheComponent, canActivate: [AuthGuard]},
  {path: 'tipo-detalhe/:id', component: TipoDetalheComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forChild(tipoRoutes)],
  exports: [RouterModule]
})
export class TipoRoutingModule { }
