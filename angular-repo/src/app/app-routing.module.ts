import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from "./views/home/home.component";
import { NormasCrudComponent } from './views/normas-crud/normas-crud.component';
import { NormasCreateComponent } from './components/normas/normas-create/normas-create.component';
import { NormasUpdateComponent } from './components/normas/normas-update/normas-update.component';
import { NormasDeleteComponent } from './components/normas/normas-delete/normas-delete.component';
import { ReportCrudComponent } from './views/report-crud/report-crud.component';
import { ProcessosCrudComponent } from './views/processos-crud/processos-crud.component';
import { SalesCrudComponent } from './views/sales-crud/sales-crud.component';
import { ReportOpenComponent } from './components/report/report-open/report-open.component';
import { DialogElementProcessoComponent } from './components/dialog-element-processo/dialog-element-processo.component';
import { ConsultoryCrudComponent } from './views/consultory-crud/consultory-crud.component';
import { ConsultoryUpdateComponent } from './components/consultory/consultory-update/consultory-update.component';
import { ConsultoryDeleteComponent } from './components/consultory/consultory-delete/consultory-delete.component';
import { ConsultoryCreateComponent } from './components/consultory/consultory-create/consultory-create.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "normas",
    component: NormasCrudComponent
  },
  {
    path: "normas/create",
    component: NormasCreateComponent
  },
  {
    path: "normas/update/:id",
    component: NormasUpdateComponent
  },
  {
    path: "normas/delete/:id",
    component: NormasDeleteComponent
  },
  {
    path: "consultorias",
    component: ConsultoryCrudComponent
  },
  {
    path: "consultorias/create",
    component: ConsultoryCreateComponent
  },
  {
    path: "consultorias/update/:id",
    component: ConsultoryUpdateComponent
  },
  {
    path: "consultorias/delete/:id",
    component: ConsultoryDeleteComponent
  },
  {
    path: "relatorios",
    component: ReportCrudComponent
  },
  {
    path: "relatorios/:id",
    component: ReportOpenComponent
  },
  {
    path: "processos",
    component: ProcessosCrudComponent
  },
  {
    path: "processos/:id",
    component: DialogElementProcessoComponent
  },
  {
    path: "vendas",
    component: SalesCrudComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
