import {Injectable} from'@angular/core';
import { Observable, of, throwError, Subject, BehaviorSubject } from'rxjs';
import { tap, map, catchError } from'rxjs/operators';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from'@angular/common/http';


@Injectable({ providedIn:'root' })
export class LoginService {
    constructor(private http:HttpClient) {}

    access_token = localStorage.getItem("token")
      
    
    apiUrl:string = "http://3.15.185.169:8091/auth";

    getJwt(usuario: object): Observable<any> {
        const url = `${this.apiUrl}/authenticate`
        console.log("URL PASSADA: ")
        console.log(url)
        return this.http.post<any>(url, usuario)
          .pipe(
            catchError(this.handleError)
          )
      }
    getRole(role: object): Observable<any> {
      const url = `${this.apiUrl}/details`
      return this.http.post<any>(url, role)
        .pipe(
          catchError(this.handleError)
        )
    }


      handleError(error: HttpErrorResponse) {
        if (error.error instanceof ErrorEvent) {
          console.error('Ocorreu o erro:', error.error.message);
        } else {
          // O backend retornou um código de resposta malsucedido.
          // O corpo da resposta pode conter pistas sobre o que deu errado
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