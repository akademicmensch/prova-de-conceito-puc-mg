import { Injectable } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { HttpClient } from "@angular/common/http";
import { Observable, EMPTY } from "rxjs";
import { map, catchError } from "rxjs/operators";
import { Processo } from './processo.model';

@Injectable({
    providedIn: "root",
  })
  export class ProcessoService {
    baseUrl = "http://3.15.185.169:8989/industrialProcess/v1/";


    constructor(private snackBar: MatSnackBar, private http: HttpClient) {}


    showMessage(msg: string, isError: boolean = false): void {
        this.snackBar.open(msg, "X", {
          duration: 3000,
          horizontalPosition: "right",
          verticalPosition: "top",
          panelClass: isError ? ["msg-error"] : ["msg-success"],
        });
      }

      public getAllProcessos() {
        return this.http.get(this.baseUrl);
      }
    

      errorHandler(e: any): Observable<any> {
        this.showMessage("Ocorreu um erro!", true);
        return EMPTY;
      }
    }