$(document).ready(function() {
	
	// Languages
	var languageSetting = 'en';
	var languageValue = $('html').eq(0).attr('lang');
	if (languageValue) {
		languageSetting = languageValue;
	}
	
	// Calendar localization
	var calendarLocale = {
		'en':{
				'daysAbbr':['S','M','T','W','T','F','S']
				,'days':['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday']
				,'months':['January','February','March','April','May','June','July','August','September','October','November','December']
				,'navigationMonths':['Previous month','Next month']
				,'navigationYears':['Previous year: ','Next year: ']
				,'closeLink':'Close calendar'
				,'focusLink':'Open calendar'
				,'startWeekOnSunday':1
		}
		,'es':{
				'daysAbbr':['L','M','M','J','V','S','D']
				,'days':['Lunes','Martes','MiÃ©rcoles','Jueves','Viernes','SÃ¡bado','Domingo']
				,'months':['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Augosto','Septiembre','Octubre','Noviembre','Diciembre']
				,'navigationMonths':['Mes anterior','Mes siguiente']
				,'navigationYears':['AÃ±o anterior: ','AÃ±o siguiente: ']
				,'closeLink':'Cerrar calendario'
				,'focusLink':'Abrir calendario'
				,'startWeekOnSunday':0
		}
		,'fr':{
				'daysAbbr':['L','M','M','J','V','S','D']
				,'days':['Lundi','Mardi','Mercredi','Jeudi','Vendredi','Samedi','Dimanche']
				,'months':['Janvier','FÃ©vrier','Mars','Avril','Mai','Juin','Juillet','AoÃ»t','Septembre','Octobre','Novembre','DÃ©cembre']
				,'navigationMonths':['Mois prÃ©cÃ©dent','Mois suivant']
				,'navigationYears':['AnnÃ©e prÃ©cÃ©dente: ','AnnÃ©e prochaine: ']
				,'closeLink':'Fermer calendrier'
				,'focusLink':'Ouvrir le calendrier'
				,'startWeekOnSunday':0
		}
	}
	
	
	
	// Call calendar function
	$.fn.calendar({
		textNavigationMonths: ['<img src="ficheros/CAL_IMG_navigation_previous.png" alt="'+calendarLocale[languageSetting]['navigationMonths'][0]+': " />','<img src="ficheros/CAL_IMG_navigation_next.png" alt="'+calendarLocale[languageSetting]['navigationMonths'][1]+': " />']
		,textNavigationYears: [calendarLocale[languageSetting]['navigationYears'][0],calendarLocale[languageSetting]['navigationYears'][1]]
		,textCloseLink: '<img src="ficheros/CAL_IMG_close.png" alt="'+calendarLocale[languageSetting]['closeLink']+'" />'
		,textFocusLink: '<img src="ficheros/CAL_IMG_icon_calendar.png" alt="'+calendarLocale[languageSetting]['focusLink']+'" />'
		,dateWeekdays: calendarLocale[languageSetting]['days']
		,dateWeekdaysAbbr: calendarLocale[languageSetting]['daysAbbr']
		,dateMonths: calendarLocale[languageSetting]['months']
		,startWeekOnSunday: calendarLocale[languageSetting]['startWeekOnSunday']
	});
});


// Calendar function
(function($){
$.fn.calendar = function(options) {
	
	var defaults = { // Opciones por defecto
		selectorPlaceCalendar: 'input[type="date"], input.date-picker'
		,selectorCalendarBox: '.calendar-box'
		,selectorCalendarBoxInline: '.calendar-box-inline'
		,selectorVisibleCalendar: '.visible-calendar-box'
		,selectorMonthArea: '.calendar-title'
		,selectorNavigation: '.calendar-nav'
		,selectorNavigationElement: 'nav'
		,selectorNavigationMonth: '.calendar-nav-months'
		,selectorNavigationYear: '.calendar-nav-years'
		,selectorTableArea: 'tbody'
		,selectorCalendarDaySelected: '.day-selected'
		,selectorNavigationMonthNext: '.calendar-nav-months-next'
		,selectorNavigationMonthPrevious: '.calendar-nav-months-previous'
		,selectorNavigationYearNext: '.calendar-nav-years-next'
		,selectorNavigationYearPrevious: '.calendar-nav-years-previous'
		,selectorCloseLink: '.close-calendar'
		
		,classesCalendarBox: 'calendar-box'
		,classesCalendarBoxInline: 'calendar-box-inline'
		,classesVisibleCalendar: 'visible-calendar-box'
		
		,classesCalendarDayWeekend: 'day-weekend'
		,classesCalendarDayActive: 'day-active'
		,classesCalendarDayInactive: 'day-inactive'
		,classesCalendarDaySelected: 'day-selected'
		,classesCalendarDayToday: 'day-today'
		,classesFirstTableColumn: 'first'
		,classesLastTableColumn: 'last'
		
		,classesCalendarTitleBox: 'calendar-title-box'
		,classesCalendarTitle: 'calendar-title'
		,dataCalendarTitleHeadingLevel: 'h4'
		
		,dataCalendarColumnsWidth:[14.2857,14.2857,14.2857,14.2857,14.2857,14.2857,14.2857]
		
		
		
		,classesHiddenElement: 'indented'
		,classesNavigation: ['calendar-nav','calendar-nav-previous','calendar-nav-next']
		,classesNavigationMonths: ['calendar-nav-months','calendar-nav-months-previous','calendar-nav-months-next']
		,classesNavigationYears: ['calendar-nav-years','calendar-nav-years-previous','calendar-nav-years-next']
		,classesCloseLink: 'close-calendar'
		,classesFocusLink: 'focus-calendar'
		
		
		,textNavigationMonths: ['Previous month: ','Next month: ']
		,textNavigationYears: ['Previous year: ','Next year: ']
		,textCloseLink: 'Close calendar'
		,textFocusLink: 'Open calendar'
		,dateWeekdays: ['Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday']
		,dateWeekdaysAbbr: ['M','T','W','T','F','S','S']
		,dateMonths: ['January','February','March','April','May','June','July','August','September','October','November','December']
		
		,startWeekOnSunday:0
		
		,stylesFocusLink2:'display:block; left:-999em; line-height:0; position:absolute; text-indent:-999em;'
		,stylesFocusLink:''
	}
	var data = {
		mouseIsInside: false
	}
	var op = $.extend(defaults, options);
	init();
	
	function init () {
		
		$(op.selectorCalendarBox).each(function () {
			$(this).addClass(op.classesCalendarBoxInline);
			narrowDates($(this),$(this),$(this));
		});
		
		$(op.selectorPlaceCalendar).each(function (index) {
			var field = $(this);
			var dateInputSupported = verifyDateInputSupport(field);
			
			if (!dateInputSupported) {
				field.attr('data-id','calendar-'+index);
				var calendarBox = $('<div></div>');
				narrowDates(field,calendarBox,field);
				calendarBox
							.attr('id','calendar-'+index+'')
							.addClass(op.classesCalendarBox)
							.hide();
				$('body').append(calendarBox);
			}
		});
		
		
		checkClickOutsideCalendar();
		createElements();
		launchCalendar();
	}
	
	function verifyDateInputSupport (field) {
		if (field.is('input[type="date"]')) {
			var dummyField = document.createElement('input');
			dummyField.setAttribute('type','date');
			return dummyField.type !== 'text';
		} else {
			return false;
		}
	}
	
	function narrowDates (field,calendarBox,limitedElement) {
		
		var minimumLimit=false;
		if (field.attr('min')) {
			var dateMinAttr = field.attr('min');
			minimumLimit=true;
		}
		if (limitedElement.attr('data-min')) {
			var dateMinAttr = limitedElement.attr('data-min');
			minimumLimit=true;
		}
		
		if (minimumLimit) {
			var dateMin = narrowDatesDeconstruct(dateMinAttr);
			calendarBox.attr({
				'data-min-year':parseInt(dateMin[0])
				,'data-min-month':parseInt(dateMin[1])
				,'data-min-day':parseInt(dateMin[2])
			});
		}
		
		var maximumLimit=false;
		if (field.attr('max')) {
			var dateMaxAttr = field.attr('max');
			maximumLimit=true;
		}
		if (limitedElement.attr('data-max')) {
			var dateMaxAttr = limitedElement.attr('data-max')
			maximumLimit=true;
		}
		if (maximumLimit) {
			var dateMax = narrowDatesDeconstruct(dateMaxAttr);
			calendarBox.attr({
				'data-max-year':parseInt(dateMax[0])
				,'data-max-month':parseInt(dateMax[1])
				,'data-max-day':parseInt(dateMax[2])
			});
		}
	}
	
	function narrowDatesDeconstruct (date) {
		return date.split('-');
	}
	
	function checkClickOutsideCalendar () {
		var calendarBox = $(op.selectorCalendarBox+':not('+op.selectorCalendarBoxInline+')');
		var calendarElements = $(op.selectorPlaceCalendar).add(calendarBox);
		
		calendarElements.hover(function(){
				data.mouseIsInside=true;
		}, function(){
				data.mouseIsInside=false;
		});

		$(document).mouseup(function(){
				if(!data.mouseIsInside) {hideCalendar();}
		});
	}
	
	function launchCalendar () {
		
		$(op.selectorPlaceCalendar).each(function (index) {
			var field = $(this);
			var position = field.offset();
			field.bind('focus',showCalendar)
		});
		
	}
	
	function showCalendar () {
		var field = $(this);
		var box = $('#'+field.attr('data-id'));
		var position = positionCalendar(box,field);
		$(op.selectorCalendarBox+':not('+op.selectorCalendarBoxInline+')').hide();
		box.css({'position':'absolute','left':position[1]+'px','top':position[0]+'px'}).addClass(op.classesVisibleCalendar).fadeIn(100,function () {
			box.find(op.selectorCloseLink+' a').eq(0).focus();
		});
	}
	
	function hideCalendar () {
		if ($(op.selectorVisibleCalendar).length>0) {	$(op.selectorVisibleCalendar).eq(0).removeClass(op.classesVisibleCalendar).fadeOut(100,function () {
				// Assign focus to link after date field
				var fieldId = $('input[data-id="'+$(this).attr('id')+'"]').eq(0).attr('id');
				$('a[href="#'+fieldId+'"]').eq(0).focus();
			});
		}
	}
	
	function positionCalendar (box,field) {
		var position = field.offset();
		var positionTop = position.top+field.outerHeight();
		var positionLeft = position.left;
		
		
		var boxHeight = box.outerHeight();
		var boxWidth = box.outerWidth();
		var positionViewportTop = $(window).scrollTop();
		var positionViewportLeft = $(window).scrollLeft();
		var viewportHeight = $(window).height();
		var viewportWidth = $(window).width();
		
		// Verify the calendar box remains inside viewport
		if ( (positionViewportTop+viewportHeight) < (positionTop+boxHeight) ) {
			positionTop = position.top-boxHeight;
		}
		if ( (positionViewportLeft+viewportWidth) < (positionLeft+boxWidth) ) {
			positionTop = position.top-boxHeight;
		} 
		
		return [positionTop,positionLeft]
	}
	
	function createElements () {
		// Retrieve present month and year, for use in creating the first calendar
		var d = new Date();
		var year = d.getFullYear();
		var month = d.getMonth();
		
		$(op.selectorCalendarBox).each(function () {
			var box = $(this);
			
			// HTML pieces insertion
			createTitleArea(box);
			if (!box.hasClass(op.classesCalendarBoxInline)) {
				createCloseLink(box);
				createFocusLink(box);
			}
			createNavigationMonths(box);
			createNavigationYears(box);
			createTable(box);
			
			updateCalendarTitle(box,month,year);
			changeMonthInTitle(box);
			
		});
	}
	
	function updateCalendarTitle (box,month,year) {
		
		// Adapt calendar to min date
		if (box.attr('data-min-year')) {
			var minYear = box.attr('data-min-year');
			var minMonth = box.attr('data-min-month');
			if ( (year-minYear)<0 ) {
				year = minYear;
				month = minMonth-1;
			} else if ( (year-minYear)==0 && box.attr('data-min-month')>(month+1) ) {
				month = minMonth-1;
			}
		}
		
		// Adapt calendar to max date
		if (box.attr('data-max-year')) {
			var maxYear = box.attr('data-max-year');
			var maxMonth = box.attr('data-max-month');
			if ( (maxYear-year)<0 ) {
				year = maxYear;
				month = maxMonth-1;
			} else if ( (maxYear-year)==0 && box.attr('data-max-month')<(month+1) ) {
				month = maxMonth-1;
			}
		}
		
		var title = box.find(op.selectorMonthArea).eq(0);
		title.html(op.dateMonths[month]+' '+year); // Updates the text in calendar (MONTH + YEAR)
		
		// Store month and year visible in the calendar
		box.attr({'data-month':month, 'data-year':year});
		
		// Create month days inside calendar table
		updateDays(box,month,year);
		
		// Months in navigation
		var monthPrevious = month-1; if (monthPrevious<0) {monthPrevious=11;}
		var monthNext = month+1; if (monthNext>11) {monthNext=0;}
		
		// Update navigation links
		updateNavigationLinks(box,year,month,monthNext,monthPrevious);
		
	}
	
	function updateNavigationLinks (box,year,month,monthNext,monthPrevious) {
		// Get navigation links
		var linkMonthNext = box.find(op.selectorNavigationMonthNext).eq(0);
		var linkMonthPrevious = box.find(op.selectorNavigationMonthPrevious).eq(0);
		var linkYearNext = box.find(op.selectorNavigationYearNext).eq(0);
		var linkYearPrevious = box.find(op.selectorNavigationYearPrevious).eq(0);
		
		// Verify max and min dates
		verifyDateLimit(box,year,month,linkYearPrevious,linkYearNext,linkMonthPrevious,linkMonthNext);
		
		// Change navigation links text
		linkMonthNext.html(op.dateMonths[monthNext]);
		linkMonthPrevious.html(op.dateMonths[monthPrevious]);
		linkYearNext.html((parseInt(year)+1));
		linkYearPrevious.html((parseInt(year)-1));
	}
	
	function verifyDateLimit (box,year,month,linkYearPrevious,linkYearNext,linkMonthPrevious,linkMonthNext) {
		// Verify previous year link
		if (box.attr('data-min-year')) {
			if ( year-box.attr('data-min-year')==1 && box.attr('data-min-month')>(month+1) ) {
				linkYearPrevious.closest('li').hide();
			} else if (year-box.attr('data-min-year')==0) {
				linkYearPrevious.closest('li').hide();
			} else {
				linkYearPrevious.closest('li').show();
			}
		}
		
		// Verify next year link
		if (box.attr('data-max-year')) {
			if ( box.attr('data-max-year')-year==1 && (month+1)>box.attr('data-max-month') ) {
				linkYearNext.closest('li').hide();
			} else if (year-box.attr('data-max-year')==0) {
				linkYearNext.closest('li').hide();
			} else {
				linkYearNext.closest('li').show();
			}
		}
		
		// Verify previous month link
		if (box.attr('data-min-month')) {
			if ( year==box.attr('data-min-year') && month<box.attr('data-min-month') ) {
				linkMonthPrevious.closest('li').hide();
			} else {
				linkMonthPrevious.closest('li').show();
			}
		}
		
		// Verify next month link
		if (box.attr('data-max-month')) {
			if ( year==box.attr('data-max-year') && month+2>box.attr('data-max-month') ) {
				linkMonthNext.closest('li').hide();
			} else {
				linkMonthNext.closest('li').show();
			}
		}
	}
	
	function changeMonthInTitle (box) {
		var enlacesMes = box.find(op.selectorNavigation+' a');
		
		enlacesMes.each(function () {
			var monthLink = $(this);
			monthLink.bind('click',function (event) {
				event.preventDefault();
				var monthBox = monthLink.closest(op.selectorNavigationElement);
				
				// According to existing class goes to previous or next month
				var adjust = 1;
				if (monthLink.attr('rel') == op.classesNavigation[1]) {
					adjust = adjust*(-1);
				}
				
				var originMonth = parseInt(box.attr('data-month'));
				var month = originMonth+adjust;
				var originYear = parseInt(box.attr('data-year'));
				var year = originYear;
				
				if (monthBox.hasClass(op.classesNavigationYears[0])) {
					year = originYear+adjust;
					updateCalendarTitle(box,originMonth,year);
				} else {
					if (month<0) {year--;month=11;}
					if (month>11) {year++;month=0;}
					updateCalendarTitle(box,month,year);
				}
				
			});
		});
	}
	
	function numberOfMonthDays (year,month) {
		var isLeap = true;
		if ((year%4)==0) {
			if ((year%100)==0) {
				isLeap = ((year%400)==0);
			}
		}
		else {isLeap = false;}
		var monthDays = [31, isLeap?29:28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
		return monthDays[month];
	}
	
	function updateDays (box,month,year) {
		var table = box.find(op.selectorTableArea).eq(0);
		table.empty();
		var currentDate = new Date();
		var currentMonth = currentDate.getUTCMonth();
		var currentDay = currentDate.getUTCDate()-1;
		var currentYear = currentDate.getUTCFullYear();
		var d = new Date(year,month,1,0,0,0,0);
		var weekDay = d.getUTCDay()+op.startWeekOnSunday;
		var previousMonth = month-1;
		if (previousMonth<0) {previousMonth=11;}
		
		var numberOfDays = numberOfMonthDays(year,month);
		var numberOfDaysPreviousMonth = numberOfMonthDays(year,previousMonth)-weekDay;
		
		var totalCalendarDays=42;
		
		var countMonthDay = 0;
		var countCalendarDay = 0;
		var countWeekDay = 0;
		var countPreviousMonthDay = weekDay;
		if (weekDay>6) {countPreviousMonthDay=0;}
		var nextMonthDay = 0;
		
		while (countCalendarDay<totalCalendarDays) {
			if (countWeekDay==0) {
				var tagRow = $('<tr></tr>');
			}
			
			// Adds next month's inactive days
			if (countMonthDay>=numberOfDays) {
				nextMonthDay++;
			}
			
			var tagCell = $('<td></td>');
			
			if (countPreviousMonthDay>0 || countMonthDay>=numberOfDays) { // Previous and next months' days
				
				var tagSpan = $('<span></span>');
				if (countPreviousMonthDay>0) {var textDay = (numberOfDaysPreviousMonth+1);}
				else {var textDay = nextMonthDay;}
				numberOfDaysPreviousMonth++;
				tagSpan.text(textDay);
				var cellContent = tagSpan;
				tagCell.addClass(op.classesCalendarDayInactive);
				
			} else { // Month days
				
				var tagLink = $('<a></a>');
				var textMonth = (month+1); if (textMonth<10) {textMonth = '0'+textMonth;}
				var textDay = (countMonthDay+1); if (textDay<10) {textDay = '0'+textDay;}
				tagLink.text((countMonthDay+1));
				tagLink.attr({'href':'#','data-date':''+year+'-'+textMonth+'-'+textDay+''});
				var cellContent = tagLink;
				
				if (month==currentMonth && countMonthDay==currentDay && year==currentYear) {
					var tagStrong = $('<strong></strong>');
					tagStrong.append(tagLink);
					var cellContent = tagStrong;
					tagCell.addClass(op.classesCalendarDayToday);
				}
				
				tagCell.addClass(op.classesCalendarDayActive);
				
				countMonthDay++;
				
			}
			
			
			
			if (countWeekDay>4) {tagCell.addClass(op.classesCalendarDayWeekend);} // Add class to weekend days
			
			tagCell.append(cellContent);
			tagRow.append(tagCell);
			if (countWeekDay==6) {
				countWeekDay=0;
				table.append(tagRow);
			} else {
				countWeekDay++;
			}
			
			countPreviousMonthDay--;
			countCalendarDay++;
		}
		
		dayLinkAction(box,table);
	}
	
	function dayLinkAction (box,table) {
		
		var enlaces = table.find('a');
		enlaces.each(function () {
			var enlace = $(this);
			enlace.bind('click',function (event) {
				event.preventDefault();
				
				if (box.hasClass(op.classesCalendarBoxInline)) {
					var celda = enlace.closest('td');
					var enlaceSeleccionado = table.find(op.selectorCalendarDaySelected);
					enlaceSeleccionado.removeClass(op.classesCalendarDaySelected)
					celda.addClass(op.classesCalendarDaySelected);
				} else {
					var field = $('input[data-id="'+box.attr('id')+'"]').eq(0);
					field.val(enlace.attr('data-date'));
					hideCalendar();
				}
			});
		});
	}
	
	function createTitleArea (box) {
		
		// Create title
		var titleTag = op.dataCalendarTitleHeadingLevel;
		var title = $('<'+titleTag+'></'+titleTag+'>');
		title.addClass(op.classesCalendarTitle);
		
		// Create title box
		var titleBox = $('<div></div>');
		titleBox.addClass(op.classesCalendarTitleBox);
		
		// Mix elements of title area and append to calendar box
		titleBox.append(title);
		box.append(titleBox);
		
	}
	
	function createFocusLink (box) {
		var field = $('input[data-id="'+box.attr('id')+'"]').eq(0);
		var focusLink = $('<a></a>');
		focusLink.attr({'href':'#'+field.attr('id'),'style':op.stylesFocusLink}).addClass(op.classesFocusLink).html(op.textFocusLink);
		field.closest('label').after(focusLink);
		focusLinkActions(field,focusLink);
	}
	
	function focusLinkActions (field,focusLink) {
		focusLink.bind('click',function (event) {
			event.preventDefault();
			field.focus();
		});
	}
	
	function createCloseLink (box) {
		// Create link
		var closeLink = $('<a></a>');
		closeLink.attr({'href':'#'}).html(op.textCloseLink);
		
		// Create paragraph
		var closeLinkContainer = $('<p></p>');
		closeLinkContainer.addClass(op.classesCloseLink).append(closeLink);
		box.append(closeLinkContainer);
		closeLinkActions(box,closeLink);
	}
	
	function closeLinkActions (box,closeLink) {
		closeLink.bind('click',function (event) {
			event.preventDefault();
			hideCalendar()
		});
	}
	
	function createNavigationMonths (box) {
		
		// Create navigation
		var navigation = createNavigationBox(op.classesNavigationMonths[0]);
		
		// Create navigation list
		var navigationList = createNavigationList();
		
		// Create 'previous' navigation element with link
		createNavigationElement(1,navigationList,op.textNavigationMonths,op.classesNavigationMonths);
		
		// Create 'next' navigation element with link
		createNavigationElement(2,navigationList,op.textNavigationMonths,op.classesNavigationMonths);
		
		// Append elements to navigation container, and adapt elements
		appendNavigationElements(box,navigationList,navigation);
		navigation.find('.'+op.classesHiddenElement).removeClass(op.classesHiddenElement).next().addClass(op.classesHiddenElement);
		
	}
	
	function createNavigationYears (box) {
		
		// Create navigation
		var navigation = createNavigationBox(op.classesNavigationYears[0]);
		
		// Create navigation list
		var navigationList = createNavigationList();
		
		// Create 'previous' navigation element with link
		createNavigationElement(1,navigationList,op.textNavigationYears,op.classesNavigationYears);
		
		// Create 'next' navigation element with link
		createNavigationElement(2,navigationList,op.textNavigationYears,op.classesNavigationYears);
		
		// Append elements to navigation container
		appendNavigationElements(box,navigationList,navigation);
		
	}
	
	function appendNavigationElements (box,navigationList,navigation) {
		navigation.append(navigationList);
		box.append(navigation);
	}
	
	function createNavigationBox (classNavigationtype) {
		var navigation = $('<nav></nav>');
		navigation.addClass(op.classesNavigation[0]).addClass(classNavigationtype);
		return navigation;
	}
	
	function createNavigationList () {
		return $('<ul></ul>');
	}
	
	function createNavigationElement (num,navigationList,textNavigation,classesNavigationYears) {
		var classes = op.classesNavigation[num];
		var text = textNavigation[num-1];
		var navigationLinkTextYear = $('<span></span>');
		navigationLinkTextYear.addClass(classesNavigationYears[num]);
		var navigationLinkText = $('<span></span>');
		navigationLinkText.append(text).addClass(op.classesHiddenElement);
		var navigationLink = $('<a></a>');
		navigationLink.attr({
			'rel':classes
			,'href':'#'
		}).append(navigationLinkText).append(navigationLinkTextYear);
		
		var navigationElement = $('<li></li>').addClass(classes).append(navigationLink);
		navigationList.append(navigationElement);
	}
	
	function createTable (box) {
		
		var table = $('<table></table>'); // Create table element
		var tableHeading = $('<thead></thead>'); // Create table heading element
		var tableBody = $('<tbody></tbody>'); // Create table body element
		
		// Create COL elements (column width)
		for (i=0;i<7;i++) {
			var columnWidth = op.dataCalendarColumnsWidth[i];
			var column = $('<col />');
			column.attr('width',columnWidth+'%');
			table.append(column);
		}
		
		// Create table heading cells
		for (i=0;i<7;i++) {
			var weekday = op.dateWeekdays[i];
			var weekdayAbbr = op.dateWeekdaysAbbr[i];
			
			// Day abbreviature
			var abbr = $('<abbr></abbr>');
			abbr.attr('title',weekday);
			abbr.append(weekdayAbbr);
			
			// Create heading
			var heading = $('<th></th>');
			if (i==0) {heading.addClass(op.classesFirstTableColumn);}
			if (i==6) {heading.addClass(op.classesLastTableColumn);}
			heading.attr('scope','col').append(abbr);
			
			// Append heading cell to heading row
			tableHeading.append(heading)
		}
		
		// Append heading and body to table
		table.append(tableHeading).append(tableBody)
		
		// Append table to box
		box.append(table);
	}
	
	
}
})(jQuery);


