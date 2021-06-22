import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material/snack-bar';
import {EMPTY, Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {catchError, map} from 'rxjs/operators';
import {Cargo} from '../../model/cargo';

@Injectable({
  providedIn: 'root'
})
export class CargoService {

  constructor(
    private httpCliente: HttpClient,
    private snackbar: MatSnackBar
  ) { }

  listarCargo(): Observable<Cargo[]> {
    const url = `${environment.config.URL_API}/cargos/listar/` ;
    const id = +localStorage.getItem('usuario_id');
    return this.httpCliente.get<Cargo[]>(url + id).pipe(
      map((dados) => dados)
    );
  }

  salvarCargo(cargo: Cargo): Observable<Cargo>{
    const url = `${environment.config.URL_API}/cargos/create` ;
    return this.httpCliente.post<Cargo>(url, cargo).pipe(
      map(obj => obj),
      catchError( (e) => this.errorHandler(e))
    );
  }

  editarCargo(cargo: Cargo): Observable<Cargo>{
    const url = `${environment.config.URL_API}/cargos/edit` ;
    return this.httpCliente.put<Cargo>(url, cargo).pipe(
      map(obj => obj),
      catchError( (e) => this.errorHandler(e))
    );
  }

  errorHandler(e: any): Observable<any>{
    this.showMessage('Ocorreu um erro!', true );
    return EMPTY;
  }

  errorHandlerDelete(e: any): Observable<any>{
    this.showMessage('Ocorreu um erro! Cargo não pode ser excluído se tiver sendo usando no cadastro de Funcionário', true );
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

  bucarCargoPorId(id: number): Observable<Cargo> {
    const url = `${environment.config.URL_API}/cargos/` ;
    return this.httpCliente.get<Cargo>(url + id).pipe(
      map((dados) => dados),
      catchError( (e) => this.errorHandler(e))
    );
  }

  deletarCargo(id: number): Observable<any> {
    const url = `${environment.config.URL_API}/cargos/delete/`;
    return this.httpCliente.delete<Cargo>(url + id).pipe(
      map((obj) => obj),
      catchError( (e) => this.errorHandlerDelete(e))
    );
  }

}
