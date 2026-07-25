import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit, OnDestroy {
  portalName = 'Student Course Portal';
  isPortalActive = true;
  message = '';
  searchTerm = '';

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }

  // 16. ngOnInit Hook
  ngOnInit(): void {
    console.log('HomeComponent initialised — courses loaded');
  }

  // 17. ngOnDestroy Hook
  ngOnDestroy(): void {
    console.log('HomeComponent destroyed');
  }
}