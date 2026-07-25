import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';

export interface EnrollmentModel {
  studentName: string;
  studentEmail: string;
  courseId: number | null;
  preferredSemester: string;
  agreeToTerms: boolean;
}

@Component({
  selector: 'app-enrollment-form',
  standalone: true,
  imports: [CommonModule, FormsModule], // FormsModule enables ngModel & ngForm
  templateUrl: './enrollment-form.component.html',
  styleUrl: './enrollment-form.component.css'
})
export class EnrollmentFormComponent {
  // 39. Form data model initialized with default values
  model: EnrollmentModel = {
    studentName: '',
    studentEmail: '',
    courseId: null,
    preferredSemester: 'Odd',
    agreeToTerms: false
  };

  // 46. Submission success state property
  submitted = false;

  // 40. Log form values and validity status on submit
  onSubmit(form: NgForm): void {
    console.log('Form Submitted!');
    console.log('Form Value:', form.value);
    console.log('Form Valid State:', form.valid);

    if (form.valid) {
      this.submitted = true;
    }
  }

  // 47. Reset method using enrollForm.resetForm()
  onReset(form: NgForm): void {
    form.resetForm({
      preferredSemester: 'Odd',
      agreeToTerms: false
    });
    this.submitted = false;
  }
}