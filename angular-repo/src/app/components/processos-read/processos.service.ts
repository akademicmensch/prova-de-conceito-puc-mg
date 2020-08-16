import { Component, OnInit } from '@angular/core';
import { RootObject } from './processos.model';


import { Injectable } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { HttpClient } from "@angular/common/http";
import { Observable, EMPTY } from "rxjs";
import { map, catchError } from "rxjs/operators";


@Injectable({
    providedIn: "root",
  })
  export class ProcessosService {
    baseUrl = "http://3.15.185.169:8989/industrialProcess/v1/";
    apiV:string;
    constructor(private http: HttpClient){}

    readAllProcesses(): Observable<RootObject[]> {
        return this.http.get<RootObject>(this.baseUrl).pipe(
            map((obj) => obj),
            catchError((e) => this.errorHandler(e))
          );
    }

    readProcess(name:string):Observable<any>{
        this.apiV = this.baseUrl+name;
        return this.http.get<any>(this.apiV).pipe(
            map((obj) => obj),
            catchError((e) => this.errorHandler(e))
        );
    }


    errorHandler(e: any): Observable<any> {
        console.log("Ocorreu um erro!");
        return EMPTY;
      }

}