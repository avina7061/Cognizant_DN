import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './course-card.component.html',
  styleUrl: './course-card.component.css'
})
export class CourseCardComponent implements OnChanges {
  @Input() course: any;

  // 18. ngOnChanges Hook
  ngOnChanges(changes: SimpleChanges): void {
    console.log('Course input changed in CourseCardComponent:', changes);
  }
}