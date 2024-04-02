import { Component } from '@angular/core';
import {
  RouterModule,
  RouterOutlet,
  RouterLink,
  RouterLinkActive,
} from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  imports: [
    CommonModule,
    NavbarComponent,
    RouterModule,
    RouterOutlet,
    RouterLink,
    RouterLinkActive,
  ],
})
export class AppComponent {
  title = 'final-project';
}
