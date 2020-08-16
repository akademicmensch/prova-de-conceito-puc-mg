import {Injectable} from'@angular/core';
import { Observable, of, throwError, Subject, BehaviorSubject, EMPTY } from'rxjs';
import { tap, map, catchError } from'rxjs/operators';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from'@angular/common/http';
import { Report } from './report.model';


@Injectable({ providedIn:'root' })
export class ReportService {
    constructor(private http:HttpClient) {}

    apiUrl:string = "http://3.15.185.169:8989/reports/v1/";
    apiUrl2:string;

    getReportsName(): Observable<Report[]>{
        return this.http.get<Report[]>(this.apiUrl).pipe(
            map((obj) => obj),
            catchError((e) => this.errorHandler(e))
          );
    }


    getReportById(id:string): Observable<any>{
        this.apiUrl2 = this.apiUrl + id;
        return this.http.get<any>(this.apiUrl2).pipe(
            catchError((e) => this.errorHandler(e))
        );
    }

    gotToLink(id: string){
        console.log('FUNCAO GO TO LINK')
        console.log('VALOR DA VARIAVEL ID: ' + id)
        this.apiUrl2 = this.apiUrl + id;
        window.open(this.apiUrl2, "_blank");
    }

    errorHandler(e: any): Observable<any> {
        console.log("Ocorreu um erro!", true);
        return EMPTY;
      }


}