# HospitalAPI

<br>

## EndPoints in Patient Controller

### POST patient/admit  -> to admit patient 
### GET patient/all -> to get all patients
### DELETE patient/discharge -> to discharge patients

<br>

## Security configs In Security Configurations

### POST patient/admit  -> only receptionist can use

 > #### .requestMatchers(request -> {
 > ####                   return "/patient/admit".equals(request.getServletPath()) && HttpMethod.POST.matches(request.getMethod());
 > ####               }).hasAuthority("receptionist")

<br>

### GET patient/all -> Docter and receptionist can use
> #### .requestMatchers(request -> {
> ####                    return "patient/all".equals(request.getServletPath()) && HttpMethod.GET.matches(request.getMethod());
> ####               }).hasAnyAuthority("Docter","receptionist")

<br>

### DELETE patient/discharge  -> only receptionist can use
> #### .requestMatchers(request -> {
> ####                    return "patient/discharge".equals(request.getServletPath()) && HttpMethod.DELETE.matches(request.getMethod());
> ####                }).hasAuthority("receptionist")

