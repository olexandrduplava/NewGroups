import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

// @ts-ignore
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { GroupService } from './group/group.service';
import { GroupComponent } from './group/group.component';
// @ts-ignore
import { AppChildComponent } from './appchild.component';
import { GroupListComponent } from './group/groupList.component';
import { PageNotFoundComponent } from './others/pageNotFound.component';
import { HomeComponent } from './group/home.component'

const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'books', component: GroupListComponent },
  { path: 'addBook', component: GroupComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    GroupComponent,
    AppChildComponent,
    GroupListComponent,
    HomeComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [GroupService],
  bootstrap: [AppComponent]
})
export class AppModule { }
