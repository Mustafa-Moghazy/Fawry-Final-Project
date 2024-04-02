import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { Routes } from '@angular/router';
import { RouterModule } from '@angular/router';

bootstrapApplication(AppComponent, appConfig).catch((err) =>
  console.error(err)
);
