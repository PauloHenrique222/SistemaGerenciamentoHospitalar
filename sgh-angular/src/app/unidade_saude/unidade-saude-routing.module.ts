import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from '../guards/auth.guard';
import {NgModule} from '@angular/core';
import {UnidadeSaudeListarComponent} from './unidade-saude-listar/unidade-saude-listar.component';
import {UnidadeSaudeDetalheComponent} from './unidade-saude-detalhe/unidade-saude-detalhe.component';

const unidadeSaudeRoutes: Routes = [
  {path: 'unidades', component: UnidadeSaudeListarComponent, canActivate: [AuthGuard]},
  {path: 'unidade-detalhe', component: UnidadeSaudeDetalheComponent, canActivate: [AuthGuard]},
  {path: 'unidade-detalhe/:id', component: UnidadeSaudeDetalheComponent, canActivate: [AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forChild(unidadeSaudeRoutes)],
  exports: [RouterModule]
})
export class UnidadeSaudeRoutingModule { }
