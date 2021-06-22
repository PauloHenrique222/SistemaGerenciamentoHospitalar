import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material/snack-bar';
import {EMPTY, Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {catchError, map} from 'rxjs/operators';
import {Departamento} from '../../model/departamento';

@Injectable({
  providedIn: 'root'
})
export class DepartamentoService {

  constructor(
    private httpCliente: HttpClient,
    private snackbar: MatSnackBar
  ) { }

  listarDepartamento(): Observable<Departamento[]> {
    const url = `${environment.config.URL_API}/departamentos/listar/` ;
    const id = +localStorage.getItem('usuario_id');
    return this.httpCliente.get<Departamento[]>(url + id).pipe(
      map((dados) => dados)
    );
  }

  salvarDepartamento(departamento: Departamento): Observable<Departamento>{
    const url = `${environment.config.URL_API}/departamentos/create` ;
    return this.httpCliente.post<Departamento>(url, departamento).pipe(
      map(obj => obj),
      catchError( (e) => this.errorHandler(e))
    );
  }

  editarDepartamento(departamento: Departamento): Observable<Departamento>{
    const url = `${environment.config.URL_API}/departamentos/edit` ;
    return this.httpCliente.put<Departamento>(url, departamento).pipe(
      map(obj => obj),
      catchError( (e) => this.errorHandler(e))
    );
  }

  errorHandler(e: any): Observable<any>{
    this.showMessage('Ocorreu um erro!', true );
    return EMPTY;
  }

  errorHandlerDelete(e: any): Observable<any>{
    this.showMessage('Ocorreu um erro! Departamento não pode ser excluído se tiver sendo usando no cadastro de Funcionário', true );
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

  bucarDepartamentoPorId(id: number): Observable<Departamento> {
    const url = `${environment.config.URL_API}/departamentos/` ;
    return this.httpCliente.get<Departamento>(url + id).pipe(
      map((dados) => dados),
      catchError( (e) => this.errorHandler(e))
    );
  }

  deletarDepartamento(id: number): Observable<any> {
    const url = `${environment.config.URL_API}/departamentos/delete/`;
    return this.httpCliente.delete<Departamento>(url + id).pipe(
      map((obj) => obj),
      catchError( (e) => this.errorHandlerDelete(e))
    );
  }

}

