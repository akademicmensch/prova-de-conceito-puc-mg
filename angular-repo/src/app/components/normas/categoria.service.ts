import { Injectable } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { HttpClient } from "@angular/common/http";
import { Observable, EMPTY } from "rxjs";
import { map, catchError } from "rxjs/operators";
import { Categoria } from './categoria.model';

@Injectable({
    providedIn: "root",
  })
  export class CategoriaService {
    baseUrl = "http://localhost:8989/normas/v1/categories";
    
    constructor(private snackBar: MatSnackBar, private http: HttpClient) {}


    showMessage(msg: string, isError: boolean = false): void {
        this.snackBar.open(msg, "X", {
          duration: 3000,
          horizontalPosition: "right",
          verticalPosition: "top",
          panelClass: isError ? ["msg-error"] : ["msg-success"],
        });
      }


    read(): Observable<Categoria[]> {
        return this.http.get<Categoria[]>(this.baseUrl).pipe(
          map((obj) => obj),
          catchError((e) => this.errorHandler(e))
        );
      }
    

      errorHandler(e: any): Observable<any> {
        this.showMessage("Ocorreu um erro!", true);
        return EMPTY;
      }


  }