import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material/snack-bar';
import {EMPTY, Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {catchError, map} from 'rxjs/operators';
import {UnidadeSaude} from '../../model/unidade-saude';
import {Tipo} from '../../model/tipo';

@Injectable({
  providedIn: 'root'
})
export class UnidadeSaudeService {
  constructor(
    private httpCliente: HttpClient,
    private snackbar: MatSnackBar
  ) { }

  listarUnidade(): Observable<UnidadeSaude[]> {
    const url = `${environment.config.URL_API}/unidades/listar/` ;
    const id = +localStorage.getItem('usuario_id');
    return this.httpCliente.get<UnidadeSaude[]>(url + id).pipe(
      map((dados) => dados)
    );
  }

  errorHandler(e: any): Observable<any>{
    this.showMessage('Ocorreu um erro!', true );
    return EMPTY;
  }

  showMessage(msg: string, isError: boolean = false): void{
    this.snackbar.open(msg, 'X', {
      duration: 3000,
      horizontalPosition: 'center',
      verticalPosition: 'bottom',
      panelClass: isError ? ['msg-error'] : ['msg-success'],
    });
  }

  bucarUnidadePorId(id: number): Observable<UnidadeSaude> {
    const url = `${environment.config.URL_API}/unidades/` ;
    return this.httpCliente.get<UnidadeSaude>(url + id).pipe(
      map((dados) => dados),
      catchError( (e) => this.errorHandler(e))
    );
  }

  salvarUnidade(unidadeSaude: UnidadeSaude): Observable<UnidadeSaude> {
    const url = `${environment.config.URL_API}/unidades/create` ;
    return this.httpCliente.post<UnidadeSaude>(url, unidadeSaude).pipe(
      map((dados) => dados),
      catchError( (e) => this.errorHandler(e))
    );
  }

  editarUnidade(unidadeSaude: UnidadeSaude): Observable<UnidadeSaude> {
    const url = `${environment.config.URL_API}/unidades/edit` ;
    return this.httpCliente.put<UnidadeSaude>(url, unidadeSaude).pipe(
      map((dados) => dados),
      catchError( (e) => this.errorHandler(e))
    );
  }

  deletarUnidade(id: number): Observable<any> {
    const url = `${environment.config.URL_API}/unidades/delete/`;
    return this.httpCliente.delete<Tipo>(url + id).pipe(
      map((obj) => obj),
      catchError( (e) => this.errorHandler(e))
    );
  }
}
