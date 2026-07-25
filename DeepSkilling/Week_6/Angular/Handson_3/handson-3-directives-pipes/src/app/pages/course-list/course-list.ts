import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
// import { CourseCardComponent, Course } from '../components/course-card/course-card.component';

@Component({
  selector: 'app-course-list',
  standalone: true,
  // imports: [CommonModule, CourseCardComponent],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css'
})
export class CourseListComponent implements OnInit {
  // 25. Loading state property
  isLoading = true;

  // courses: Course[] = [
  //   { id: 101, name: 'Angular Fundamentals', code: 'CS101', credits: 3, gradeStatus: 'passed' },
  //   { id: 102, name: 'Data Structures & Algorithms', code: 'CS102', credits: 4, gradeStatus: 'failed' },
  //   { id: 103, name: 'Database Management Systems', code: 'CS103', credits: 3, gradeStatus: 'pending' },
  //   { id: 104, name: 'Web Security & Risk', code: 'CS104', credits: 1, gradeStatus: 'passed' },
  //   { id: 105, name: 'Cloud Infrastructure', code: 'CS105', credits: 0, gradeStatus: 'pending' }
  // ];

  selectedCourseId: number | null = null;

  ngOnInit(): void {
    // 25. Simulate 1.5 seconds loading timer
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  // 26. trackBy method
  // Returns a unique identifier for each item. Without trackBy, Angular destroys and re-creates
  // all DOM nodes when an array changes. With trackBy, Angular reuses existing elements and only updates changed items.
  // trackByCourseId(index: number, course: Course): number {
  //   return course.id;
  // }

  onEnroll(courseId: number): void {
    this.selectedCourseId = courseId;
    // const targetCourse = this.courses.find(c => c.id === courseId);
    // if (targetCourse) {
    //   targetCourse.isEnrolled = true;
    // }
  }

  clearCourses(): void {
    // this.courses = [];
  }
}