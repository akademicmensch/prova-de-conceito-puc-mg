import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/template/header/header.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { FooterComponent } from './components/template/footer/footer.component';
import { NavComponent } from './components/template/nav/nav.component';

import { MatSidenavModule } from  '@angular/material/sidenav';
import { MatCardModule } from  '@angular/material/card';
import { MatListModule } from '@angular/material/list';
import { HomeComponent } from './views/home/home.component';
import { MatButtonModule } from  '@angular/material/button';
import { MatSnackBarModule } from  '@angular/material/snack-bar';
import { HttpClientModule } from  '@angular/common/http';
import {MatSelectModule} from '@angular/material/select';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { RedDirective } from './directives/red.directive';

import localePt from '@angular/common/locales/pt';
import { registerLocaleData } from  '@angular/common';
import { ForDirective } from './directives/for.directive';
import { LoginComponent } from './login/login.component';
import { NormasReadComponent } from './components/normas/normas-read/normas-read.component';
import { NormasCreateComponent } from './components/normas/normas-create/normas-create.component';
import { NormasUpdateComponent } from './components/normas/normas-update/normas-update.component';
import { NormasDeleteComponent } from './components/normas/normas-delete/normas-delete.component';
import { ReportReadComponent } from './components/report/report-read/report-read.component';
import { SalesReadComponent } from './components/sales/sales-read/sales-read.component';
import { ConsultoryReadComponent } from './components/consultory/consultory-read/consultory-read.component';
import { ConsultoryUpdateComponent } from './components/consultory/consultory-update/consultory-update.component';
import { ConsultoryDeleteComponent } from './components/consultory/consultory-delete/consultory-delete.component';
import { NormasCrudComponent } from './views/normas-crud/normas-crud.component';
import { ConsultoryCrudComponent } from './views/consultory-crud/consultory-crud.component';
import { ReportCrudComponent } from './views/report-crud/report-crud.component';
import { SalesCrudComponent } from './views/sales-crud/sales-crud.component';
import { ProcessosCrudComponent } from './views/processos-crud/processos-crud.component';
import { ReportOpenComponent } from './components/report/report-open/report-open.component';
import { ProcessosReadComponent } from './components/processos-read/processos-read.component';
import { DialogElementProcessoComponent } from './components/dialog-element-processo/dialog-element-processo.component';
import {MatDialogModule} from '@angular/material/dialog';
import { ConsultoryCreateComponent } from './components/consultory/consultory-create/consultory-create.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { ModalDescricaoComponent } from './components/normas/modal-descricao/modal-descricao.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ModalProcessoComponent } from './components/processos-read/modal-processo/modal-processo.component';
registerLocaleData(localePt);

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    RedDirective,
    ForDirective,
    LoginComponent,
    NormasReadComponent,
    NormasCreateComponent,
    NormasUpdateComponent,
    NormasDeleteComponent,
    ReportReadComponent,
    SalesReadComponent,
    ConsultoryReadComponent,
    ConsultoryUpdateComponent,
    ConsultoryDeleteComponent,
    NormasCrudComponent,
    ConsultoryCrudComponent,
    ReportCrudComponent,
    SalesCrudComponent,
    ProcessosCrudComponent,
    ReportOpenComponent,
    ProcessosReadComponent,
    DialogElementProcessoComponent,
    ConsultoryCreateComponent,
    ModalDescricaoComponent,
    ModalProcessoComponent,
  ],
  entryComponents:[DialogElementProcessoComponent, ModalDescricaoComponent, ModalProcessoComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatButtonModule,
    MatSnackBarModule,
    HttpClientModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatDialogModule,
    MatSelectModule,
    MatProgressSpinnerModule,
    FlexLayoutModule,
    ReactiveFormsModule
  ],
  providers: [{
    provide: LOCALE_ID,
    useValue: 'pt-BR'
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
