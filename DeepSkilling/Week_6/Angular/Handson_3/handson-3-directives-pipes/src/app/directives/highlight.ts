import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {
  // 37. Configurable background color via @Input, defaulting to yellow
  @Input() appHighlight: string = 'yellow';

  constructor(private el: ElementRef) {}

  // 33. Add hover background color on mouseenter
  @HostListener('mouseenter') onMouseEnter(): void {
    this.highlight(this.appHighlight || 'yellow');
  }

  // 33. Clear background color on mouseleave
  @HostListener('mouseleave') onMouseLeave(): void {
    this.highlight('');
  }

  private highlight(color: string): void {
    this.el.nativeElement.style.backgroundColor = color;
  }
}