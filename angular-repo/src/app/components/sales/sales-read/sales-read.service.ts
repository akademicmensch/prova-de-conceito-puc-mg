import {Injectable} from'@angular/core';
import { Observable, of, throwError, Subject, BehaviorSubject } from'rxjs';
import { tap, map, catchError } from'rxjs/operators';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from'@angular/common/http';

@Injectable({ providedIn:'root' })
export class SalesService {
    constructor(private http:HttpClient) {}


    apiUrl:string = "http://3.15.185.169:8989/sales/v1/";


    getSales(sales:object): Observable<any> {
        return this.http.get<any>(this.apiUrl, sales)
        .pipe(
            catchError(this.handleError)
          )
    }


    handleError(error: HttpErrorResponse) {
        if (error.error instanceof ErrorEvent) {
          console.error('Ocorreu o erro:', error.error.message);
        } else {
          if(error.status == 401){
            alert("A sessão foi expirada")
          }
          console.error(
            `Status  ${error.status}, ` +
            `corpo do erro: ${error.message}`);
        }
        // retorna um observable com mensagem de erro
        return throwError(
          'Não foi possível realizar a ação, tente novamente');
      };

}