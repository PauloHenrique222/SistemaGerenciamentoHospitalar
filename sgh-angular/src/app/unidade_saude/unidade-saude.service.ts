import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material/snack-bar';
import {EMPTY, Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {catchError, map} from 'rxjs/operators';
import {UnidadeSaude} from '../../model/unidade-saude';

@Injectable({
  providedIn: 'root'
})
export class UnidadeSaudeService {
  constructor(
    private httpCliente: HttpClient,
    private snackbar: MatSnackBar
  ) { }

  listarUnidade(): Observable<UnidadeSaude[]> {
    const url = `${environment.config.URL_API}/unidades` ;
    return this.httpCliente.get<UnidadeSaude[]>(url).pipe(
      map((tipos) => tipos)
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
      map((tipo) => tipo),
      catchError( (e) => this.errorHandler(e))
    );
  }
}
