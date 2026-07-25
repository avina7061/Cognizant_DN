import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
// import { HighlightDirective } from '../../directives/highlight.directive';
// import { CreditLabelPipe } from 'src/app/pipes/credit-label.pipe';

export interface Course {
  id: number;
  name: string;
  code: string;
  credits: number;
  gradeStatus: 'passed' | 'failed' | 'pending';
  isEnrolled?: boolean;
}

@Component({
  selector: 'app-course-card',
  standalone: true,
  // imports: [CommonModule, HighlightDirective, CreditLabelPipe],
  templateUrl: './course-card.component.html',
  styleUrl: './course-card.component.css'
})
export class CourseCardComponent {
  @Input() course!: Course;
  @Output() enrollRequested = new EventEmitter();

  // 31. Expansion toggle property
  isExpanded = false;

  // 32. Getter for ngClass object binding
  // Keeping object binding logic inside a getter keeps the HTML template clean, readable, and easy to test.
  get cardClasses() {
    return {
      'card--enrolled': !!this.course?.isEnrolled,
      'card--full': this.course?.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  // 30. Getter for ngStyle dynamic left border color
  get borderStyle() {
    let borderColor = 'grey';
    if (this.course?.gradeStatus === 'passed') borderColor = 'green';
    if (this.course?.gradeStatus === 'failed') borderColor = 'red';

    return { 'border-left': `6px solid ${borderColor}` };
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  onEnroll(): void {
    this.enrollRequested.emit(this.course.id);
  }
}