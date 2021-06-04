import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material/snack-bar';
import {EMPTY, Observable} from 'rxjs';
import {TipoDto} from '../../model/tipo-dto';
import {environment} from '../../environments/environment';
import {catchError, map} from 'rxjs/operators';
import {UnidadeSaudeDto} from '../../model/unidade-saude-dto';
import {UnidadeSaudeDao} from '../../model/unidade-saude-dao';

@Injectable({
  providedIn: 'root'
})
export class UnidadeSaudeService {
  constructor(
    private httpCliente: HttpClient,
    private snackbar: MatSnackBar
  ) { }

  listarUnidade(): Observable<UnidadeSaudeDto[]> {
    const url = `${environment.config.URL_API}/unidades` ;
    return this.httpCliente.get<UnidadeSaudeDto[]>(url).pipe(
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

  bucarUnidadePorId(id: number): Observable<UnidadeSaudeDao> {
    const url = `${environment.config.URL_API}/unidades/` ;
    return this.httpCliente.get<UnidadeSaudeDao>(url + id).pipe(
      map((tipo) => tipo),
      catchError( (e) => this.errorHandler(e))
    );
  }
}
