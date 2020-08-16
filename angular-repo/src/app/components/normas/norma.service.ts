import { Injectable } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { HttpClient } from "@angular/common/http";
import { Observable, EMPTY } from "rxjs";
import { map, catchError } from "rxjs/operators";
import { Norma } from './norma.model';
import { NormaCreateModel } from './normas-create/NormaCreate.model';
import { ReponseTypeToPDF } from './reponsepdf.model';

@Injectable({
    providedIn: "root",
  })
  export class NormaService {
    baseUrl = "http://localhost:8989/normas/v1/";
    
    constructor(private snackBar: MatSnackBar, private http: HttpClient) {}

    normaC:NormaCreateModel = new NormaCreateModel();

    responsePdf:ReponseTypeToPDF;

    showMessage(msg: string, isError: boolean = false): void {
        this.snackBar.open(msg, "X", {
          duration: 3000,
          horizontalPosition: "right",
          verticalPosition: "top",
          panelClass: isError ? ["msg-error"] : ["msg-success"],
        });
      }

    create(norma: NormaCreateModel): Observable<NormaCreateModel> {
        return this.http.post<NormaCreateModel>(this.baseUrl, norma).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
        );
    }


      read(): Observable<Norma[]> {
        
        return this.http.get<Norma[]>(this.baseUrl).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
        );
      }


      readById(id: number): Observable<Norma> {
        const url = `${this.baseUrl}${id}`;
        return this.http.get<Norma>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
        );
      }
    
      update(norma: Norma): Observable<NormaCreateModel> {

        //Transformar Objeto aqui
        this.normaC.descricao = norma.descricao;
        this.normaC.nome = norma.nome
        this.normaC.processo = norma.processo
        this.normaC.consultoria = norma.consultoria
        this.normaC.categoria = norma.categoria
        this.normaC.status = 1
        this.normaC.processo = norma.processo

        console.log('OBJETO TRANFORMADO PARA CONTRATO EM NORMA UPDATE')
        console.log(this.normaC)

        const url = `${this.baseUrl}${norma.id}`;
        return this.http.put<NormaCreateModel>(url, this.normaC).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
        );
      }


      deleteNorma(id: number): Observable<Norma> {
        const url = `${this.baseUrl}${id}`;
        return this.http.delete<Norma>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
        );
      }


      getByteArrayPdf(id: string): Observable<ReponseTypeToPDF>{
        let url = "http://localhost:8092/normas/v1/";
        url = url.concat(id);
        url = url.concat("/pdf")
        console.log('URL FINAL DO NORMA SERVICE')
        console.log(url)
        return this.http.get<ReponseTypeToPDF>(url).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
        );
      }

     

      errorHandler(e: any): Observable<any> {
        console.log(e);
        return EMPTY;
      }
}