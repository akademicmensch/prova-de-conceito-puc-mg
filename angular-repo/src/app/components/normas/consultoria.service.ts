import { Injectable } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { HttpClient } from "@angular/common/http";
import { Observable, EMPTY } from "rxjs";
import { map, catchError } from "rxjs/operators";
import { Consultoria } from './consultoria.model';
import { Consultoria2 } from './consultoria2.model';
import { ConsultoriaCreate } from '../consultory/consultory-create/consultoriaCreate.model';
import {ConsultoriaUpdate} from '../consultory/consultory-update/consultoriaUpdate.model';


@Injectable({
    providedIn: "root",
  })
  export class ConsultoriaService {
    baseUrl = "http://localhost:8989/consultorias/v1/";


    constructor(private snackBar: MatSnackBar, private http: HttpClient) {}


    showMessage(msg: string, isError: boolean = false): void {
        this.snackBar.open(msg, "X", {
          duration: 3000,
          horizontalPosition: "right",
          verticalPosition: "top",
          panelClass: isError ? ["msg-error"] : ["msg-success"],
        });
      }


      read(): Observable<Consultoria[]> {
        return this.http.get<Consultoria[]>(this.baseUrl).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
        );
      }

      public getAll() {
        return this.http.get(this.baseUrl);
      }
      


      readModel2(): Observable<Consultoria2[]> {
        return this.http.get<Consultoria2[]>(this.baseUrl).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
        );
      }

      readById(id: number): Observable<Consultoria2> {
        const url = `${this.baseUrl}${id}`;
        return this.http.get<Consultoria2>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
        );
      }

      createConsultoria(consultoria: ConsultoriaCreate): Observable<ConsultoriaCreate> {
        return this.http.post<ConsultoriaCreate>(this.baseUrl, consultoria).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
        );
    }

    consultoria:ConsultoriaUpdate = new ConsultoriaUpdate();
    update(cons: Consultoria2): Observable<ConsultoriaUpdate> {

      //Transformar Objeto aqui

      this.consultoria.fimContrato = cons.fimContrato.toString();
      console.log(cons.fimContrato.toString());
      console.log('OBJETO TRANFORMADO PARA CONTRATO EM Consultoria UPDATE')
      console.log(this.consultoria)

      const url = `${this.baseUrl}${cons.id}`;
      return this.http.put<ConsultoriaUpdate>(url, this.consultoria).pipe(
        map((obj) => obj),
        catchError((e) => this.errorHandler(e))
      );
    }



    delete(id: number): Observable<Consultoria2> {
      const url = `${this.baseUrl}${id}`;
      return this.http.delete<Consultoria2>(url).pipe(
        map((obj) => obj),
        catchError((e) => this.errorHandler(e))
      );
    }


      errorHandler(e: any): Observable<any> {
        this.showMessage("Ocorreu um erro!", true);
        return EMPTY;
      }



  }