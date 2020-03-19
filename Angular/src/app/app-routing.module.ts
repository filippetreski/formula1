import { AboutComponent } from './about/about.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
const routes: Routes = [
{path: 'about/:language', component: AboutComponent},
{path: 'home/:language', component: AppComponent},
{path: '**', redirectTo: '/home/en'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  
exports: [RouterModule]
})
export class AppRoutingModule { }
