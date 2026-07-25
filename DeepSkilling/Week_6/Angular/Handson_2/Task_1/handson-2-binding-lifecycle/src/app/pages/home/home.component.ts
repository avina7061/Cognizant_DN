import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Required for ngModel

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  // 1. Interpolation property
  portalName = 'Student Course Portal';

  // 2. Property binding property
  isPortalActive = true;

  // 3. Event binding message
  message = '';

  // 4. Two-way binding property
  searchTerm = '';

  // Event binding handler
  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }
}