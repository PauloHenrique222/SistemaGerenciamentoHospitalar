import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material/snack-bar';
import {EMPTY, Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {catchError, map} from 'rxjs/operators';
import {TipoDto} from '../../model/tipo-dto';

@Injectable({
  providedIn: 'root'
})
export class TipoService {

  constructor(
    private httpCliente: HttpClient,
    private snackbar: MatSnackBar
  ) { }

  listarTipo(): Observable<TipoDto[]> {
    const url = `${environment.config.URL_API}/tipos` ;
    return this.httpCliente.get<TipoDto[]>(url).pipe(
      map((tipos) => tipos)
    );
  }

  salvarTipo(tipo: TipoDto): Observable<TipoDto>{
    const url = `${environment.config.URL_API}/tipos/create` ;
    return this.httpCliente.post<TipoDto>(url, tipo).pipe(
      map(obj => obj),
      catchError( (e) => this.errorHandler(e))
    );
  }

  editarTipo(tipo: TipoDto): Observable<TipoDto>{
    const url = `${environment.config.URL_API}/tipos/edit` ;
    return this.httpCliente.put<TipoDto>(url, tipo).pipe(
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

  bucarTipoPorId(id: number): Observable<TipoDto> {
    const url = `${environment.config.URL_API}/tipos/` ;
    return this.httpCliente.get<TipoDto>(url + id).pipe(
      map((tipo) => tipo),
      catchError( (e) => this.errorHandler(e))
    );
  }

}
