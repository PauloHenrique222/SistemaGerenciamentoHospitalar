import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material/snack-bar';
import {EMPTY, Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {catchError, map} from 'rxjs/operators';
import {Tipo} from '../../model/tipo';

@Injectable({
  providedIn: 'root'
})
export class TipoService {

  constructor(
    private httpCliente: HttpClient,
    private snackbar: MatSnackBar
  ) { }

  listarTipo(): Observable<Tipo[]> {
    const url = `${environment.config.URL_API}/tipos/listar/` ;
    const id = +localStorage.getItem('usuario_id');
    return this.httpCliente.get<Tipo[]>(url + id).pipe(
      map((tipos) => tipos)
    );
  }

  salvarTipo(tipo: Tipo): Observable<Tipo>{
    const url = `${environment.config.URL_API}/tipos/create` ;
    return this.httpCliente.post<Tipo>(url, tipo).pipe(
      map(obj => obj),
      catchError( (e) => this.errorHandler(e))
    );
  }

  editarTipo(tipo: Tipo): Observable<Tipo>{
    const url = `${environment.config.URL_API}/tipos/edit` ;
    return this.httpCliente.put<Tipo>(url, tipo).pipe(
      map(obj => obj),
      catchError( (e) => this.errorHandler(e))
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

  bucarTipoPorId(id: number): Observable<Tipo> {
    const url = `${environment.config.URL_API}/tipos/` ;
    return this.httpCliente.get<Tipo>(url + id).pipe(
      map((tipo) => tipo),
      catchError( (e) => this.errorHandler(e))
    );
  }

  deletarTipo(id: number): Observable<any> {
    const url = `${environment.config.URL_API}/tipos/delete/`;
    return this.httpCliente.delete<Tipo>(url + id).pipe(
      map((obj) => obj),
      catchError( (e) => this.errorHandler(e))
    );
  }

}
